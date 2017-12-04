package notes.dao;

import notes.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by vijay on 28/9/17.
 */
@Transactional
public interface NotesDao extends MongoRepository<Notes,Long> {
    List<Notes> findNotesByUserName(String userName);
    Notes findNotesById(String id);
    //List<Notes> findNotesByUserNameAndCreatedDateBetween(String userName, DateTime fromDate, DateTime toDate);
    int countByUserName(String userName);
}
