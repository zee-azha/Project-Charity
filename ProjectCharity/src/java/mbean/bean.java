/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Doni
 */
public class bean {
     public void validateName(FacesContext fc, UIComponent c, Object value)
    {
     if ( ((String)value).contains("A-Z"))
            throw new ValidatorException(
            new FacesMessage("You Must Value Money"));
    }
    
}
