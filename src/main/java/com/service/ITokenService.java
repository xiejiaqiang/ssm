package com.service;
import com.entity.po.Token;
import java.util.Map;
public interface ITokenService {

	public void insertToken(Token t);

	@SuppressWarnings("rawtypes")
	public Token findOneToken(Map map);

}
