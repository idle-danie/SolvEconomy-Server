package sogong.solveconomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sogong.solveconomy.domain.Dict;
import sogong.solveconomy.dto.DictResponseDTO;
import sogong.solveconomy.repository.DictRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class DictService {

    @Autowired
    private DictRepository dictRepository;

    public List<DictResponseDTO> getAllDicts() {
        return dictRepository.findAll().stream()
                .map(dict -> new DictResponseDTO(dict.getId(), dict.getKeyword()))
                .collect(Collectors.toList());
    }

    public Optional<Dict> getDictById(Long id) {
        return dictRepository.findById(id);
    }

    public List<Dict> searchDicts(String keyword) {
        return dictRepository.findByKeywordContaining(keyword);
    }

    public Dict getRandomDict() {
        List<Dict> allDicts = dictRepository.findAll();
        if (allDicts.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return allDicts.get(random.nextInt(allDicts.size()));
    }
}