package ru.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Админ on 08.04.2017.
 */
public class Groups extends ForwardingSet <GroupData> {
    private Set<GroupData> delegate;

    public Groups(Groups group) {
        this.delegate = new HashSet<GroupData>(group.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set delegate() {
        return delegate;
    }
    public Groups withAdded (GroupData group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }
    public Groups without(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }

}
