package lab1.operations;

abstract class Operations {


    String choice;
    String message;

    public Operations(){
        this.displayMessage();
        this.getInput();
    }

    public abstract void displayMessage();
    public abstract void getInput();
    public abstract void executeChoice();




}
