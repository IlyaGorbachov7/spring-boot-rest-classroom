package softarex.gorbachev.springbootrestclassroom.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import softarex.gorbachev.springbootrestclassroom.controllers.constants.OperationType;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class DataSender<T> {
    private OperationType operation;
    private T data;

    public DataSender() {
    }

    public DataSender(OperationType operation, T data) {
        this.operation = operation;
        this.data = data;
    }
}
