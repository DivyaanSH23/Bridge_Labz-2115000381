import java.util.*;

public class MovieManagement {
    class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie next, prev;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    Movie head, tail;

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
            return;
        }
        newMovie.next = temp.next;
        temp.next.prev = newMovie;
        temp.next = newMovie;
        newMovie.prev = temp;
    }

    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    public void searchMovie(String key) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(key) || String.valueOf(temp.rating).equals(key)) {
                System.out.println("Movie Found: " + temp.title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie Not Found");
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayMoviesReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }
}
