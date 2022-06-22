import elements.Treetype;

public class Main {
    public static void main(String[] args) {

        ConiferTree coniferTree = new ConiferTree("Sosna");


        coniferTree.showYourself();
        coniferTree.grow();
        coniferTree.showYourself();
        coniferTree.grow();
        coniferTree.showYourself();
        coniferTree.grow();
        coniferTree.showYourself();
        coniferTree.putOnDecorations();
        coniferTree.showYourself();


        LeafyTree leafyTree = new LeafyTree();
        leafyTree.showYourself();
        leafyTree.grow();
        leafyTree.showYourself();
        leafyTree.grow();
        leafyTree.grow();
        leafyTree.showYourself();
        leafyTree.lostAllLeaves();
        leafyTree.showYourself();
    }
}
