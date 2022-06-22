package elements;

import elements.branchelem.BranchElement;
import elements.branchelem.Leaf;
import elements.branchelem.Needle;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Setter
@Getter
@Slf4j
public class Branch {
    private Set<Branch> childBranches;
    private Set<BranchElement> branchElements;
    private  final int maxChildBranchesPerBranch = 2;
    private final int maxBranchElementsPerBranch = 5;
    private final Treetype treetype;

    public Branch(Treetype treetype){
        this.childBranches = new HashSet<>();
        this.branchElements = new HashSet<>();
        this.treetype = treetype;
        setRandomBranchElements();
    }

    public void setRandomBranchElements() {
        Random random = new Random();
        int amountElementsToadd = random.nextInt(maxBranchElementsPerBranch) + 1;
        if(treetype.equals(Treetype.LEAFY)){
            for(int i = 0; i <= amountElementsToadd; i ++){
                branchElements.add(new Leaf());
            }
        }else if(treetype.equals(Treetype.CONIFER)){
            for(int i = 0; i <= amountElementsToadd; i ++){
                branchElements.add(new Needle());
            }
        }
    }

    public void addNewBranch(){
        childBranches.add(new Branch(treetype));
    }
    public boolean hasNoChildBranches(){
        return childBranches.size() == 0;
    }
    public boolean doesntHaveFreeSpaceForNewChildBranch(){
        return childBranches.size() >= maxChildBranchesPerBranch;
    }

    public void addNewBranchElement(BranchElement newElement) {
        if(branchElements.size() < maxBranchElementsPerBranch){
            log.info("Adding new element to branch");
            branchElements.add(newElement);
        }else {
            log.info("Branch is full, can not add new element");
        }
    }

    public void deleteAllElements() {
        branchElements.clear();
    }

    public int getAmountOfLeavesOrNeedels() {
        int amountofLeavesOrNeedels = 0;
        for (BranchElement elem : branchElements){
            if (elem.getClass() == Leaf.class || elem.getClass() == Needle.class){
                amountofLeavesOrNeedels++;
            }
        }
        return amountofLeavesOrNeedels;
    }

    public int getAmountOfAllBranchElements() {
        int amountofAllBranchElements = 0;
        for (BranchElement elem : branchElements){
            amountofAllBranchElements++;
        }
        return amountofAllBranchElements;
    }

    public int getChildBranchesAmount() {
        return childBranches.size();
    }
}
