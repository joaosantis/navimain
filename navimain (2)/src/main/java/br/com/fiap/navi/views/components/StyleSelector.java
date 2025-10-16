package br.com.fiap.navi.views.components;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.select.Select;

public class StyleSelector extends Select<String> {

    public StyleSelector() {
        super();
        this.setHelperText("Escolha um estilo de escrita para a tradução");
        this.setPrefixComponent(VaadinIcon.CHAT.create());
        this.setMinWidth("300px");
        this.setItems(
            "Gíria das Ruas",
            "Criança de 2 Anos",
            "Juridiquês",
            "Caipira",
            "Fausto Silva"
        );
        this.setEmptySelectionAllowed(false);
    }
}
