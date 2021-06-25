package org.easybookmark.api;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;


@ApplicationScoped
@Transactional(REQUIRED)
public class BookmarkService {

    @Transactional(SUPPORTS)
    public List<Bookmark> findAll(){
        return Bookmark.listAll();
    }

    @Transactional(SUPPORTS)
    public Bookmark findByTaskId(String id){
        return Bookmark.find("taskId", id).firstResult();
    }

    @Transactional(SUPPORTS)
    public Bookmark findById(long id) {
        return Bookmark.findById(id);
    }

    public Bookmark add(@Valid Bookmark bookmark) {
        Bookmark.persist(bookmark);
        return bookmark;
    }

    public Bookmark update(@Valid Bookmark bookmark) {
        Bookmark entity = findById(bookmark.id);
        entity.title = bookmark.title;
        entity.description = bookmark.description;
        if (bookmark.addresses.size() > 0){
            entity.addresses = bookmark.addresses;
        }
        return entity;
    } 

    public void delete(Long id) {
        Bookmark.deleteById(id);
    }
}