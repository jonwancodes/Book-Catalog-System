I implemented a book cataloging system

In this system, book files can be loaded, parsed, and managed in a book catalog.  Books
(represented by a Book class) are loaded and stored in a book catalog (represented by a
BookCatalog class).  A BookFileReader class will take care of initially loading the book files and
doing some basic clean-up.

The Book class will take care of extracting the book title and author, counting the total number
of words, and getting a count of each unique word (case-insensitive).  The BookCatalog class
will allow for adding books and looking up books based on their title or author.

Overall, the program will load three different book files (.txt) with BookFileReader, create three
Book objects, and store them in BookCatalog.  The required methods are already called in the
main method in each section of the exam.
