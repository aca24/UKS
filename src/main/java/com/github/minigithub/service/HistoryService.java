package com.github.minigithub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.dto.HistoryDTO;
import com.github.minigithub.model.History;
import com.github.minigithub.repository.HistoryRepository;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;

	public List<HistoryDTO> searchByComment(String input) {
		List<History> found = historyRepository.searchByComment(input);
		List<HistoryDTO> retVal = new ArrayList<HistoryDTO>();
		for(History h: found) {
			retVal.add(new HistoryDTO(h));
		}
		return retVal;
	}

	public HistoryDTO save(HistoryDTO input) {
		History h = new History();
		h.setComment(input.getComment());
		System.out.println(h.getComment());
		try {
			System.out.println("tryrfhsdk");
			h = historyRepository.save(h);
			return new HistoryDTO(h);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

}
