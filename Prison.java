package TP_QUALITE;
 class Prison extends Case {

    public Prison() {
        super("Prison");
    }

    public void action(){
        for(Joueur j:getJoueurPresent()){
            j.vaEnPrison();
        }
    }
}

