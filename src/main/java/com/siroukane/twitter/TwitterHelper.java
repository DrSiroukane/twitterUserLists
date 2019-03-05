package com.siroukane.twitter;

import twitter4j.*;

import java.util.List;

/**
 * @author Slimane SIROUKANE
 *
 * TwitterHelper class
 */
public class TwitterHelper {

    private Twitter twitter;

    public TwitterHelper(Twitter twitter) {
        this.twitter = twitter;
    }

    public List<UserList> getUserLists() throws TwitterException {
        return twitter.getUserLists(twitter.getId());
    }

    public List<User> getListMembers(UserList userList) throws TwitterException {
        return twitter.getUserListMembers(userList.getId(), -1);
    }

    public List<User> getListSubscribers(UserList userList) throws TwitterException {
        return twitter.getUserListSubscribers(userList.getId(), -1);
    }

    public List<Status> getListTweets(UserList userList) throws TwitterException {
        return twitter.getUserListStatuses(userList.getId(), new Paging());
    }

}
