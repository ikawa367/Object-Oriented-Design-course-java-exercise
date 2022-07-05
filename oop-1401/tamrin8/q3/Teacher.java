import utility.*;

public class Teacher extends Member implements Identifiable {
    char[] teachersCode;
    private int numberOfBooks;
    private Book takenBooks[];

    public Teacher(String fName, String lName, String nationalcode, char[] teacherCode) {
        super(fName, lName, nationalcode);
        this.teachersCode = teacherCode;
        this.setMemberID(teacherCode);
        this.setMembersAcctype(AccountType.TheMember);
    }

    public boolean addTakenBooks(Book input) {
        if (input.getBookSituation() == BookState.AVAILABLE) {
            input.lend();
            numberOfBooks++;
            takenBooks[numberOfBooks] = input;
            return true;
        } else {
            System.out.println("book is not available");
            return false;
        }
    }

    public boolean returnTakenBook(Book input) {
        for (int i = 0; i <= numberOfBooks; i++) {
            if (takenBooks[i].equals(input)) {
                input.takeBack();
                numberOfBooks--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void SetID(char[] input) {
        teachersCode = input;
    }

    @Override
    public char[] GetID() {
        return teachersCode;
    }
}
