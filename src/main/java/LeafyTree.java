
import elements.Branch;
import elements.Treetype;
import interfaces.LoosingAllBranchElements;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Slf4j
public class LeafyTree extends Tree implements LoosingAllBranchElements {
    private static final String nameOfBranchElement = "leaf";

    public LeafyTree(String species) {
        super(Treetype.LEAFY, species,nameOfBranchElement);
    }

    public LeafyTree() {
        super(Treetype.LEAFY, nameOfBranchElement);

    }


    @Override
    public void lostAllLeaves() {
        Set<Branch> currentBranchesToSearch = new HashSet<>(Arrays.asList(this.trunk.getPrimaryBranch()));
        while (searchingTreeNotCompleted(currentBranchesToSearch)){
            for (Branch branch : currentBranchesToSearch){
                branch.deleteAllElements();
            }
            currentBranchesToSearch = returnAllchildrens(currentBranchesToSearch);
        }
    }


}
