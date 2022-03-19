package com.fastxpo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;

import com.fastxpo.bean.Partner;

public interface PartnerService {
	

    public Partner save(@NotNull @Valid final Partner partner) ;
    public Partner signUp(@NotNull @Valid final Partner partner);
	public Partner login(@NotNull @Valid final Partner partner) ;
    


}
