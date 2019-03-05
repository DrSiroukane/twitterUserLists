package com.siroukane.twitter;

import twitter4j.*;

import java.util.List;

/**
 * @author Slimane SIROUKANE
 *
 * Twitter main app
 */
public class TwitterApp
{
    public static void main( String[] args )
    {
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        TwitterHelper th = new TwitterHelper(twitter);

        try {
            // user lists
            System.out.println("print user lists");
            List<UserList> userLists = th.getUserLists();
            for (UserList userList : userLists) {
                System.out.println(userList.getName());
            }
            System.out.println("\n");

            // user lists members
            for (UserList userList : userLists) {
                System.out.println("print members of user list '" + userList.getName() + "'");
                for (User user : th.getListMembers(userList)) {
                    System.out.println(user.getName());
                }
                System.out.println("\n");
            }

            // user lists subscribers
            for (UserList userList : userLists) {
                System.out.println("print subscribers of user list '" + userList.getName() + "'");
                for (User user : th.getListSubscribers(userList)) {
                    System.out.println(user.getName());
                }
                System.out.println("\n");
            }

            // user lists tweets
            for (UserList userList : userLists) {
                System.out.println("print tweets of user list '" + userList.getName() + "'");
                for (Status status : th.getListTweets(userList)) {
                    System.out.println(status);
                }
                System.out.println("\n");
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }

    }
}
