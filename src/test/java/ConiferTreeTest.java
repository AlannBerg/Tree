import elements.Branch;
import elements.Treetype;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;


public class ConiferTreeTest extends JUnit4Builder {


    @Test
    public void newTreeShouldHaveNameAsSetName(){
        String name = "species";
        ConiferTree coniferTree = new ConiferTree(name);
        Assert.assertEquals(name,coniferTree.getSpecies());
    }
    
    @Test
    public void newTreeShouldHaveNameAsTreeType(){
        ConiferTree coniferTree = new ConiferTree();
        Assert.assertEquals(coniferTree.getTreeType().name(),coniferTree.getSpecies());
    }

    @Test
    public void newTreeShouldHave1Branch() {
        ConiferTree coniferTree = new ConiferTree();
        Assert.assertEquals(1, coniferTree.getBranchesAmount());

    }

    @Test
    public void newTreeShouldHaveTreeTypeConifer(){
        ConiferTree coniferTree = new ConiferTree();
        Assert.assertEquals(Treetype.CONIFER, coniferTree.getTreeType());
    }

    @Test
    public void growShouldIncreaseAmoutOfBranchges(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        Assert.assertEquals(2, coniferTree.getBranchesAmount());
    }

    @Test
    public void growShouldIncreaseAmoutOfBranchgesatEachSide(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.grow();
        Assert.assertEquals(5, coniferTree.getBranchesAmount());
    }

    @Test
    public void putOnDecoratesShouldTryToPutOnSomeDecorations(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.putOnDecorations();
        int amountOfDecorates = coniferTree.getDecorationsAmount();
        Assert.assertTrue(amountOfDecorates > 0);
    }

    @Test
    public void returnAllChildrensShouldReturn2(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.grow();
        Set<Branch> childrensSet = coniferTree.returnAllchildrens(
                new HashSet<>(Arrays.asList(coniferTree.trunk.getPrimaryBranch()))
        );
        Assert.assertEquals(2,childrensSet.size());
    }
    @Test
    public void getLeavesOrNeedleAmountShouldNotBe0AfterGrow(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        int needlesAmount = coniferTree.getLeavesOrNeedelAmount();
        Assert.assertTrue(needlesAmount > 0);
    }
    @Test
    public void getLeavesOrNeedleAmountShouldBe0BeforeGrow(){
        ConiferTree coniferTree = new ConiferTree();
        int needlesAmount = coniferTree.getLeavesOrNeedelAmount();
        Assert.assertTrue(needlesAmount == 0);
    }
    @Test
    public void getDecorationsAmountShouldReturnDec(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.putOnDecorations();
        Assert.assertTrue(coniferTree.getDecorationsAmount() > 0);
    }

    @Test
    public void getDecorationsAmountShouldNotHaveAnyDecoration(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.grow();
        coniferTree.grow();
        coniferTree.grow();
        Assert.assertTrue(coniferTree.getDecorationsAmount() == 0);
    }

}

