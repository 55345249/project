package com.primeton.service;

import com.primeton.domain.CapUser;
import com.primeton.domain.PageInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

	List<CapUser> queryUser(PageInfo pageInfo);

	Integer totalCount();

}
