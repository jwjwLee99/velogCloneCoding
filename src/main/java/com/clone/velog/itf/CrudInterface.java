package com.clone.velog.itf;

import com.clone.velog.models.network.Header;

public interface CrudInterface<Req, Res> {
    public Header<Res> create(Header<Req> request);
    public String read(Integer id);
    public Header<Res> update(Header<Req> request);
    public String delete(Integer id);   
}
