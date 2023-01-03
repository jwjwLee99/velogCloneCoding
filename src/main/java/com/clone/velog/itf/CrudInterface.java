package com.clone.velog.itf;

import com.clone.velog.models.network.Header;

public interface CrudInterface<Req, Res> {
    public Header<Res> create(Header<Req> request);

    public Header<Res> read(Integer id);

    public Header<Res> update(Header<Req> request);

    public Header delete(Integer id);
}
