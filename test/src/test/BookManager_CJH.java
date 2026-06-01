
public class BookManager_CJH {
	private Set<String> Books = new HashSet<>();

    public void addBook(String name) {
        if (books.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 학생입니다: " + name);
        }
        books.add(name);
    } 

}
