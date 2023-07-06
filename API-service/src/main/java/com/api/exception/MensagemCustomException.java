package com.api.exception;

/**
 *
 * @author Miguel Castro
 */
public class MensagemCustomException extends RuntimeException {

    public MensagemCustomException(String mensagem) {
        super(mensagem);
    }
}