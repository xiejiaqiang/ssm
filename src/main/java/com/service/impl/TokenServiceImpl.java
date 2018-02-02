package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.entity.po.Example.TokenExample;
import com.entity.po.Token;
import com.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TokenMapper;

@Service("tokenService")
public class TokenServiceImpl implements ITokenService {

	@Autowired
	TokenMapper tokenMapper;

	public void insertToken(Token t) {
		tokenMapper.insert(t);
	};

	@SuppressWarnings("rawtypes")
	public Token findOneToken(Map map) {
		String token = (String) map.get("token");
		Date expireTime = (Date) map.get("expireTime");
		TokenExample example = new TokenExample();
		example.createCriteria().andTokenEqualTo(token).andExpiretimeGreaterThanOrEqualTo(expireTime);
		List<Token> tokenList = tokenMapper.selectByExample(example);
		return tokenList.isEmpty() ? null : tokenList.get(0);
	};

}
