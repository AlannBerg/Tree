import elements.Branch;
import elements.Treetype;
import elements.branchelem.Decoration;
import interfaces.Christmas;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public final class ConiferTree extends Tree implements Christmas {
    private static final String nameOfBranchElement = "needel";

    public ConiferTree(String species) {
        super(Treetype.CONIFER, species, nameOfBranchElement);
    }

    public ConiferTree() {
        super(Treetype.CONIFER, nameOfBranchElement);
    }


    @Override
    public void putOnDecorations() {
        Set<Branch> currentBranchesToAddDecorations = new HashSet<>(Arrays.asList(this.trunk.getPrimaryBranch()));
        while (searchingTreeNotCompleted(currentBranchesToAddDecorations)){
            for (Branch branch : currentBranchesToAddDecorations){
                branch.addNewBranchElement(new Decoration());
            }
            currentBranchesToAddDecorations = returnAllchildrens(currentBranchesToAddDecorations);
        }
    }

    @Override
    public void showYourself() {
        super.showYourself();
        int decorationsAmount = getDecorationsAmount();
        if(decorationsAmount > 0){
            log.info(String.format("I have %d decorations", getDecorationsAmount()));
        }
    }

    protected int getDecorationsAmount() {
        return this.getAllBranchElementsAmount() - this.getLeavesOrNeedelAmount();
    }
}
