package elements;

import lombok.Getter;


@Getter
public class Trunk {
    private final Branch primaryBranch;

    public Trunk(Branch primaryBranch){
        this.primaryBranch = primaryBranch;
    }
}
