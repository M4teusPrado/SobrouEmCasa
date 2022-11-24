package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.model.Usuario;

public interface InterfaceLoginService {

    Usuario login(String email, String senha);
}
