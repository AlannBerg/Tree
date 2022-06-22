import elements.Branch;
import elements.Treetype;
import elements.Trunk;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Slf4j
public abstract class Tree {
    protected final Trunk trunk;
    private final Treetype treeType;
    private final String species;
    private final String branchElementName;
    private Set<Branch> branchesOnthetop;


    public Tree(Treetype treeType, String species, String branchElementName){
        this.trunk = new Trunk(
                new Branch(treeType)
        );
        this.treeType = treeType;
        this.species = species;
        this.branchElementName = branchElementName;
        this.branchesOnthetop = new HashSet<>();
        branchesOnthetop.add(trunk.getPrimaryBranch());
    }
    public Tree(Treetype treeType, String branchElementName){
        this.trunk = new Trunk(
                new Branch(treeType)
        );
        this.treeType = treeType;
        this.species = treeType.name();
        this.branchElementName = branchElementName;
        this.branchesOnthetop = new HashSet<>();
        branchesOnthetop.add(trunk.getPrimaryBranch());
    }

    public void grow(){
        if(branchesOnTopHaveNoSpaceToAddNewBranch()){
            setNewBranchesOnTOp();
            log.info("Tree getting higher");
        }
        addNewBranchTo(branchesOnthetop);
    }


    private void setNewBranchesOnTOp() {

        Set<Branch> newtheHighestBranches = new HashSet<>();
        for(Branch branch : branchesOnthetop){
            newtheHighestBranches.addAll(branch.getChildBranches());
        }
        this.branchesOnthetop = newtheHighestBranches;
    }

    private boolean branchesOnTopHaveNoSpaceToAddNewBranch() {
        boolean thereisNoMoreSpace = false;
        for (Branch branch : branchesOnthetop){
            if(branch.doesntHaveFreeSpaceForNewChildBranch()){
                thereisNoMoreSpace = true;
            }
        }
        return thereisNoMoreSpace;
    }

    public  void showYourself(){
        log.info(String.format(
                "My name is %s, my type is %s, I have %d branch/es , I have %d %s",
                species, treeType.name(), getBranchesAmount(), getLeavesOrNeedelAmount(), branchElementName )
        );
    }

    private void addNewBranchTo(Set<Branch> branches){
        for(Branch branch : branches){
            branch.addNewBranch();
        }
    }
    protected boolean searchingTreeNotCompleted(Set<Branch> currentBranchesToAddDecorations) {
        boolean notcompleted = true;
        for(Branch branch : currentBranchesToAddDecorations){
            if(branch.hasNoChildBranches()){
                notcompleted = false;
            }
        }
        return notcompleted;
    }
    protected Set<Branch> returnAllchildrens(Set<Branch> branches) {
        Set<Branch> setOfChildrens = new HashSet<>();
        for(Branch branch : branches){
            setOfChildrens.addAll(branch.getChildBranches());
        }
        return setOfChildrens;
    }

    protected int getLeavesOrNeedelAmount(){
        int amountOfLeavesOrNeedels = 0;

        Set<Branch> currentBranchesToSearch = new HashSet<>(Arrays.asList(trunk.getPrimaryBranch()));
        while (searchingTreeNotCompleted(currentBranchesToSearch)){
            for (Branch branch : currentBranchesToSearch){
                amountOfLeavesOrNeedels += branch.getAmountOfLeavesOrNeedels();
            }
            currentBranchesToSearch = returnAllchildrens(currentBranchesToSearch);
        }
        return amountOfLeavesOrNeedels;
    }

    protected int getAllBranchElementsAmount(){
        int amountOfAllBranchElements = 0;
        Set<Branch> currentBranchesToSearch = new HashSet<>(Arrays.asList(trunk.getPrimaryBranch()));
        while (searchingTreeNotCompleted(currentBranchesToSearch)){
            for (Branch branch : currentBranchesToSearch){
                amountOfAllBranchElements += branch.getAmountOfAllBranchElements();
            }
            currentBranchesToSearch = returnAllchildrens(currentBranchesToSearch);
        }
        return amountOfAllBranchElements;
    }

    protected int getBranchesAmount(){
        int amountOfBranches = 1;
        Set<Branch> currentBranchesToSearch = new HashSet<>(Arrays.asList(trunk.getPrimaryBranch()));
        while (searchingTreeNotCompleted(currentBranchesToSearch)){
            for (Branch branch : currentBranchesToSearch){
                amountOfBranches += branch.getChildBranchesAmount();
            }
            currentBranchesToSearch = returnAllchildrens(currentBranchesToSearch);
        }
        return amountOfBranches;
    }
}
