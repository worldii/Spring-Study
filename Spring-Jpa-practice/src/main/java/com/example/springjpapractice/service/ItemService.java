package com.example.springjpapractice.service;

import com.example.springjpapractice.domain.item.Item;
import com.example.springjpapractice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행되어야 함
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }
    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
