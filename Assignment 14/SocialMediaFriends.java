import java.util.*;

public class SocialMediaFriends {
    class User {
        int userId;
        String name;
        int age;
        List<Integer> friends;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }

    User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null && user1 != user2) {
            user1.friends.add(userId2);
            user2.friends.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friends) {
                if (user2.friends.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        }
    }

    public void searchUser(String searchKey) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(searchKey) || String.valueOf(temp.userId).equals(searchKey)) {
                System.out.println("User Found: " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User Not Found");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
