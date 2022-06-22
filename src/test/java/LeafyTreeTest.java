import elements.Branch;
import elements.Treetype;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeafyTreeTest extends JUnit4Builder {

    @Test
    public void newTreeShouldHaveNameAsSetName(){
        String name = "species";
        LeafyTree leafyTree = new LeafyTree(name);
        Assert.assertEquals(name,leafyTree.getSpecies());
    }

    @Test
    public void newTreeShouldHaveNameAsTreeType(){
        LeafyTree leafyTree = new LeafyTree();
        Assert.assertEquals(leafyTree.getTreeType().name(),leafyTree.getSpecies());
    }

    @Test
    public void newTreeShouldHave1Branch() {
        LeafyTree leafyTree = new LeafyTree();
        Assert.assertEquals(1, leafyTree.getBranchesAmount());

    }

    @Test
    public void newTreeShouldHaveTreeTypeConifer(){
        LeafyTree leafyTree = new LeafyTree();
        Assert.assertEquals(Treetype.LEAFY, leafyTree.getTreeType());
    }

    @Test
    public void growShouldIncreaseAmoutOfBranchges(){
        LeafyTree leafyTree = new LeafyTree();
        leafyTree.grow();
        Assert.assertEquals(2, leafyTree.getBranchesAmount());
    }

    @Test
    public void growShouldIncreaseAmoutOfBranchgesatEachSide(){
        LeafyTree leafyTree = new LeafyTree();
        leafyTree.grow();
        leafyTree.grow();
        leafyTree.grow();
        Assert.assertEquals(5, leafyTree.getBranchesAmount());
    }

    @Test
    public void leaveLeavesShouldLostAllLeavesButNobranches(){
        LeafyTree leafyTree = new LeafyTree();
        leafyTree.grow();
        leafyTree.grow();
        leafyTree.grow();
        Assert.assertTrue(leafyTree.getLeavesOrNeedelAmount() > 0);
        Assert.assertTrue(leafyTree.getBranchesAmount() > 0);
        leafyTree.lostAllLeaves();
        Assert.assertTrue(leafyTree.getLeavesOrNeedelAmount() == 0);
        Assert.assertTrue(leafyTree.getBranchesAmount() > 0);
    }

    @Test
    public void returnAllChildrensShouldReturn2(){
        LeafyTree leafyTree = new LeafyTree();
        leafyTree.grow();
        leafyTree.grow();
        leafyTree.grow();
        Set<Branch> childrensSet = leafyTree.returnAllchildrens(
                new HashSet<>(Arrays.asList(leafyTree.trunk.getPrimaryBranch()))
        );
        Assert.assertEquals(2,childrensSet.size());
    }
    @Test
    public void getLeavesOrNeedleAmountShouldNotBe0AfterGrow(){
        LeafyTree leafyTree = new LeafyTree();
        leafyTree.grow();
        int needlesAmount = leafyTree.getLeavesOrNeedelAmount();
        Assert.assertTrue(needlesAmount > 0);
    }
    @Test
    public void getLeavesOrNeedleAmountShouldBe0BeforeGrow(){
        LeafyTree leafyTree = new LeafyTree();
        int leavesAmount = leafyTree.getLeavesOrNeedelAmount();
        Assert.assertTrue(leavesAmount == 0);
    }
}
