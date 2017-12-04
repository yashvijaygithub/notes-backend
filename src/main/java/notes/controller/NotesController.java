package notes.controller;

import notes.dto.ResponseDto;
import notes.dto.UserNotesDto;
import notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vijay on 28/9/17.
 */
@RestController
public class NotesController {

    private static final String SUCCESS = "Success";
    private static final String FAILURE = "Failure";

    @Autowired
    NotesService notesService;

    @RequestMapping(value="/api", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> welcome(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(SUCCESS);
        responseDto.setMessage("Welcome message from SpringBoot");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @RequestMapping(value="/api/createNewNotes", method = RequestMethod.POST)
    public ResponseDto createData(@RequestBody UserNotesDto userNotesDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            responseDto = notesService.createNewNotes(userNotesDto,responseDto);
            responseDto.setStatus(SUCCESS);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value="/api/fetchNotes", method = RequestMethod.GET)
    public ResponseDto readData(@RequestParam String userName){
        ResponseDto responseDto = new ResponseDto();
        try{
            responseDto = notesService.fetchNotesByUser(userName,responseDto);
            responseDto.setStatus(SUCCESS);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }


    @RequestMapping(value="/api/updateNotes", method = RequestMethod.POST)
    public ResponseDto updateData(@RequestBody UserNotesDto userNotesDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            String message = notesService.updateNotes(userNotesDto);
            responseDto.setStatus(SUCCESS);
            responseDto.setMessage(message);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value="/api/deleteNotes", method = RequestMethod.DELETE)
    public ResponseDto deleteData(@RequestParam String id){
        ResponseDto responseDto = new ResponseDto();
        try{
            String message = notesService.deleteNotes(id);
            responseDto.setStatus(SUCCESS);
            responseDto.setMessage(message);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value="/api/fetchNotesByDate", method = RequestMethod.GET)
    public ResponseDto readDatabyDate(@RequestParam String userName,@RequestParam String fromDate,@RequestParam String toDate){
        ResponseDto responseDto = new ResponseDto();
        try{
            /*List<Notes> notes = notesService.fetchNotesByUserBetweenDates(userName,fromDate,toDate);
            responseDto.setStatus(SUCCESS);
            responseDto.setResponseData(notes);*/
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }
}
