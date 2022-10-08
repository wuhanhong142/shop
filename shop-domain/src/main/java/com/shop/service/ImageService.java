package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.ImageDO;
import com.shop.repoistory.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ImageService extends ServiceImpl<ImageDO, ImageRepository> {

}
