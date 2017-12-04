package notes.service;

import notes.dao.NotesDao;
import notes.dto.ResponseDto;
import notes.dto.UserNotesDto;
import notes.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vijay on 28/9/17.
 */
@Service
public class NotesService {
    @Autowired
    NotesDao notesDao;

    public ResponseDto createNewNotes(UserNotesDto userNotesDto,ResponseDto responseDto) throws ParseException {
        try {
            if (null != userNotesDto) {
                Notes notes = new Notes();
                notes.setUserName(userNotesDto.getUserName());
                notes.setCreatedDate(parseDate(userNotesDto.getDateFromClient()));
                notes.setText(userNotesDto.getText());
                notesDao.save(notes);
                List<Notes> allNotes = notesDao.findNotesByUserName(userNotesDto.getUserName());
                responseDto.setResponseData(allNotes);
                responseDto.setMessage("Notes added");
            }
        }catch (Exception e){
            responseDto.setErrorLog("failed with exeception :" +e.getMessage());
            return responseDto;
        }
        return responseDto;
    }

    public ResponseDto fetchNotesByUser(String userName,ResponseDto responseDto){
        int result = notesDao.countByUserName(userName);
        if(result > 0) {
            List<Notes> notes = notesDao.findNotesByUserName(userName);
             responseDto.setMessage("Username "+ userName+" already exists!! with "+ notes.size() + " previous records");
             responseDto.setResponseData(notes);
        } else {
            responseDto.setMessage("Username "+userName+" added!! and No records found");
        }
        return responseDto;
    }

    public String updateNotes(UserNotesDto userNotesDto) throws ParseException {
        try {
            if (null != userNotesDto) {
                Notes notes = notesDao.findNotesById(userNotesDto.getId());
                notes.setCreatedDate(parseDate(userNotesDto.getDateFromClient()));
                notes.setText(userNotesDto.getText());
                notesDao.save(notes);
            }
        }catch (Exception e){
            return "failed with exeception :" + e.getMessage();
        }
        return "Notes updated for id :" +userNotesDto.getId();
    }

    public String deleteNotes(String id) {
        try {
            if (null != id) {
                Notes notes = notesDao.findNotesById(id);
                notesDao.delete(notes);
            }
        } catch (Exception e){
            return "failed with exeception :" + e.getMessage();
        }
        return "Notes deleted for id:" + id;
    }

    /*public List<Notes> fetchNotesByUserBetweenDates(String userName,String from,String to){
        DateTime fromDate = new DateTime().minusDays(2);
        DateTime toDate = new DateTime().plusDays(2);

        List<Notes> notes = notesDao.findNotesByUserNameAndCreatedDateBetween(userName,fromDate,toDate);
        return notes;
    }*/
    
    private String parseDate(Date dateFromClient) throws ParseException {
        SimpleDateFormat toDisplay = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
        return toDisplay.format(dateFromClient);
    }
}
