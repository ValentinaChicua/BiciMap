package RepairPoints;

import java.util.ArrayList;
import java.util.List;

public class kdtree {
    private static final int K = 2;
    private nodo root;
    public kdtree() {
        root = null;
    }
    public void insert(double[] coordenada) {
        root = insert(root,coordenada,0);
    }
    public nodo insert(nodo node, double[] coordenada,int depth) {
        if (node == null) {
            return new nodo(coordenada, depth);
        }

        int axis = depth % K;
        if(coordenada[axis]<node.coordenada[axis]) {
            node.left = insert(node.left,coordenada,depth+1);
        }else {
            node.right=insert(node.right,coordenada,depth+1);
        }
        return node;
    }
    public List<double[]> findPointsWithinDistance(double[] target, double maxDistance) {
        List<double[]> result = new ArrayList<>();
        findPointsWithinDistance(root, target, maxDistance, result, 0);
        return result;
    }

    private void findPointsWithinDistance(nodo node, double[] target, double maxDistance, List<double[]> result, int depth) {
        if (node == null) {
            return;
        }

        double distance = haversine(node.coordenada[0], node.coordenada[1], target[0], target[1]);

        if (distance <= maxDistance) {
            result.add(node.coordenada);
        }

        int axis = depth % K;
        double axisDistance = node.coordenada[axis] - target[axis];

        if (axisDistance * axisDistance <= maxDistance * maxDistance) {
            findPointsWithinDistance(node.left, target, maxDistance, result, depth + 1);
            findPointsWithinDistance(node.right, target, maxDistance, result, depth + 1);
        } else if (axisDistance < 0) {
            findPointsWithinDistance(node.right, target, maxDistance, result, depth + 1);
        } else {
            findPointsWithinDistance(node.left, target, maxDistance, result, depth + 1);
        }
    }
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra en kilómetros

        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);

        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
