
import elements.Branch;
import elements.Treetype;
import elements.branchelem.BranchElement;
import elements.branchelem.Decoration;
import elements.branchelem.Leaf;
import elements.branchelem.Needle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;

import java.util.Set;

public class BranchTest extends JUnit4Builder {

    @Test
    public void branchForLeafyTreeShouldHaveLeaves(){
        Branch branch = new Branch(Treetype.LEAFY);
        Set<BranchElement> leafs = branch.getBranchElements();
        for(BranchElement elem : leafs){
            Assert.assertEquals(Leaf.class,elem.getClass());
        }
    }
    @Test
    public void branchForConiferTreeShouldHaveNeedels(){
        Branch branch = new Branch(Treetype.CONIFER);
        Set<BranchElement> needles = branch.getBranchElements();
        for(BranchElement elem : needles){
            Assert.assertEquals(Needle.class,elem.getClass());
        }
    }
    @Test
    public void addNewBranchShouldIncreaseChildBranchesLeaf(){
        Branch branch = new Branch(Treetype.LEAFY);
        int beforeAdd = branch.getChildBranchesAmount();
        branch.addNewBranch();
        Assert.assertTrue(branch.getChildBranchesAmount() > beforeAdd);
    }
    @Test
    public void addNewBranchShouldIncreaseChildBranchesConf(){
        Branch branch = new Branch(Treetype.CONIFER);
        int beforeAdd = branch.getChildBranchesAmount();
        branch.addNewBranch();
        Assert.assertTrue(branch.getChildBranchesAmount() > beforeAdd);
    }

    @Test
    public void hasNoChildBranchesShouldReturnTrueLeaf(){
        Branch branch = new Branch(Treetype.LEAFY);
        Assert.assertTrue(branch.hasNoChildBranches());
    }
    @Test
    public void hasNoChildBranchesShouldReturnTrueConf(){
        Branch branch = new Branch(Treetype.CONIFER);
        Assert.assertTrue(branch.hasNoChildBranches());

    }
    @Test
    public void hasNochildBranchesShouldReturnFalseLeaf(){
        Branch branch = new Branch(Treetype.LEAFY);
        branch.addNewBranch();
        Assert.assertFalse(branch.hasNoChildBranches());
    }
    @Test
    public void hasNochildBranchesShouldReturnFalseConf(){
        Branch branch = new Branch(Treetype.CONIFER);
        branch.addNewBranch();
        Assert.assertFalse(branch.hasNoChildBranches());
    }
    @Test
    public void doesntHaveFreeSpaceForNewChildShoudlReturnTrueLeaf(){
        Branch branch = new Branch(Treetype.LEAFY);
        for(int i = 0; i < branch.getMaxChildBranchesPerBranch(); i++){
            branch.addNewBranch();
        }
        Assert.assertTrue(branch.doesntHaveFreeSpaceForNewChildBranch());
    }
    @Test
    public void doesntHaveFreeSpaceForNewChildShoudlReturnTrueConf(){
        Branch branch = new Branch(Treetype.CONIFER);
        for(int i = 0; i < branch.getMaxChildBranchesPerBranch(); i++){
            branch.addNewBranch();
        }
        Assert.assertTrue(branch.doesntHaveFreeSpaceForNewChildBranch());
    }
    @Test
    public void doesntHaveFreeSpaceForNewChildShoudlReturnFalseLeaf(){
        Branch branch = new Branch(Treetype.LEAFY);
        Assert.assertFalse(branch.doesntHaveFreeSpaceForNewChildBranch());
    }
    @Test
    public void addNewBranchElementShouldAddNewConf(){
        Branch branch = new Branch(Treetype.CONIFER);
        Assert.assertFalse(branch.doesntHaveFreeSpaceForNewChildBranch());
    }
    @Test
    public void deleteAllElenentsShouldDelete(){
        Branch branch = new Branch(Treetype.CONIFER);
        branch.setRandomBranchElements();
        branch.setRandomBranchElements();
        branch.deleteAllElements();
        Assert.assertEquals(0,branch.getBranchElements().size());
    }
    @Test
    public void getAmoutOfLeavesOrNeedelsShouldReturn5(){
        Branch branch = new Branch(Treetype.CONIFER);
        branch.deleteAllElements();
        for(int i = 0; i < branch.getMaxBranchElementsPerBranch() ; i++){
            branch.addNewBranchElement(new Needle());
        }
        Assert.assertEquals(branch.getMaxBranchElementsPerBranch() , branch.getAmountOfLeavesOrNeedels());
    }
    @Test
    public void getAmountOfAllBranchElementsShouldReturn5(){
        Branch branch = new Branch(Treetype.CONIFER);
        branch.deleteAllElements();
        for(int i = 0; i < branch.getMaxBranchElementsPerBranch() ; i++){
            branch.addNewBranchElement(new Decoration());
        }
        Assert.assertEquals(branch.getMaxBranchElementsPerBranch() , branch.getAmountOfAllBranchElements());
    }

}
