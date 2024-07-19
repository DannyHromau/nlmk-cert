package com.nlmk.mes.rolling.messages;

import com.nlmk.mes.rolling.messages.message.MessageEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Множество сообщений.
 *
 * @author rustamminibaev
 */
@Getter
@AllArgsConstructor
public enum Messages implements MessageEnum {

    /**
     * OK.
     */
    OK(0, "ok"),

    /**
     * NOT_FOUND.
     */
    NOT_FOUND(1, "{0} с {1} {2} отсутствует"),

    /**
     * Ошибка валидации.
     */
    VALIDATION_ERROR(2, "Ошибка валидации: поле {0} - {1}"),

    /**
     * Найдено несколько справочных значений.
     */
    MORE_THEN_ONE_NSI_FOUNDED(3, "Найдено несколько справочных значений в справочнике {0} для кода {1}"),

    /**
     * Неверное указание склада и места.
     */
    WRONG_OBJECT_MODEL_HIERARCHY(4, "Место с идентификатором {0} не принадлежит складу с идентификатором {1}"),

    /**
     * Неверное указание идентификатора склада.
     */
    WRONG_WAREHOUSE_ID(6, "Переданный идентификатор склада {0} не совпадает с текущим {1}"),

    /**
     * Попытка изменить/удалить операцию над ЕСУ, имеющую последующие операции.
     */
    NOT_LAST_OPERATION(7, "Операция с идентификатором {0} не является последней выполненной у ЕСУ с идентификатором {1}"),

    /**
     * Отсутствие записи о предыдущих операциях.
     */
    PREVIOUS_HISTORY_IS_ABSENT(8, "Складская единица с идентификатором {0} не имеет записи о предыдущих операциях"),

    /**
     * Не передан код статуса.
     */
    STATUS_CODE_IS_NULL(9, "Отсутствует новый код статуса для операции смены статуса ЕСУ с идентификатором {0}"),

    /**
     * Недопустимый код статуса.
     */
    INVALID_STATUS_CODE(10, "Для операции смены статуса ЕСУ с идентификатором {0} передан недопустимый код статуса - {1}"),

    /**
     * Чтобы не править последний код.
     */
    DUMMY_MESSAGE(999, "DUMMY");

    /**
     * Имя множества сообщений.
     */
    public static final String SOURCE = "warehouse";

    /**
     * Код ошибки.
     */
    private int code;

    /**
     * Формат сообщения.
     */
    private String textPattern;

    @Override
    public String getSource() {
        return SOURCE;
    }

}
