// Copyright 2001, FreeHEP.
package org.freehep.util.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to keep registered Tags, which should be used by the
 * TaggedIn/OutputStream.
 * 
 * A set of recognized Tags can be added to this class. A concrete
 * implementation of this stream should install all allowed tags.
 * 
 * @author Mark Donszelmann
 * @author Charles Loomis
 * @version $Id: TagSet.java 8584 2006-08-10 23:06:37Z duns $
 */
public class TagSet {

    /**
     * This holds the individual tags.
     */
    protected Map tags;

    /**
     * The default tag handler.
     */
    protected Tag defaultTag;

    /**
     * Creates a Tag Set.
     */
    public TagSet() {
        // Initialize the tag classes.
        defaultTag = new UndefinedTag();
        tags = new HashMap();
    }

    /**
     * Add a new tag to this set. If the tagID returned is the DEFAULT_TAG, then
     * the default handler is set to the given handler.
     * @param tag tag to be added to set
     */
    public void addTag(Tag tag) {
        int id = tag.getTag();
        if (id != Tag.DEFAULT_TAG) {
            tags.put(new Integer(id), tag);
        } else {
            defaultTag = tag;
        }
    }

    /**
     * Find tag for tagID.
     * @param tagID tagID to find
     * @return correspoding tag or UndefinedTag if tagID is not found.
     */
    public Tag get(int tagID) {
        Tag tag = (Tag) tags.get(new Integer(tagID));
        if (tag == null)
            tag = defaultTag;
        return tag;
    }

    /**
     * Finds out if Tag for TagID exists.
     * 
     * @param tagID tagID to find
     * @return true if corresponding Tag for TagID exists
     */
    public boolean exists(int tagID) {
        return (tags.get(new Integer(tagID)) != null);
    }
}
