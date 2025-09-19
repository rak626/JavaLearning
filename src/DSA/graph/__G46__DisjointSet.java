package DSA.graph;


import DSA.utils.DisjointSet;

public class __G46__DisjointSet {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.find(3) == ds.find(7)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

        ds.unionByRank(3, 7);

        if (ds.find(3) == ds.find(7)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

    }
}
