[![pipeline status](https://git.nlmk.com/mes-rolling/nlmk-mes-warehouse/badges/develop/pipeline.svg)](https://git.nlmk.com/mes-rolling/nlmk-mes-warehouse/-/commits/develop)
[![coverage report](https://git.nlmk.com/mes-rolling/nlmk-mes-warehouse/badges/develop/coverage.svg)](https://git.nlmk.com/mes-rolling/nlmk-mes-warehouse/-/commits/develop)


# Сервис склада
## Минимальные требования
- для Linux: docker-compose версии 1.28.4 и выше
- для Microsoft Windows: Docker Desktop версии 3.3.3 и выше
- для Mac OS: Docker Desktop версии 4.3.0 и выше
- 10Гб свободного дискового пространства (в большей степени зависит от размера развёрнутой базы данных)
- 8Гб свободной оперативной памяти

## Запуск проекта
1. Необходимо добавить наш приватный Maven репозиторий в свой settings.xml если он существует. Или создать новый и добавить в него.<br>
   1.1. Так же необходимо будет попросить чтобы через https://ots.nlmk.com/ переслали пароль к репозиторию.

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>nlmk-mes-rolling-central</id>
            <username>mes-rolling-maven-ro</username>
            <password>из пункта 1.1</password>
        </server>
        <server>
            <id>nlmk-mes-rolling-central-snapshots</id>
            <username>mes-rolling-maven-ro</username>
            <password>из пункта 1.1</password>
        </server>
    </servers>
</settings>
```
   1.1.1. settings.xml находится в папке m2 (для Unix / Mac OS X — ~/.m2 для Windows — C:Users\{your-username}\.m2<br>
   Если по умолчанию .m2 не удается найти, возможно, кто-то изменил путь по умолчанию.<br> 
   Введите следующую команду, чтобы узнать, где находится локальный репозиторий Maven:
```sh
    mvn help:evaluate -Dexpression=settings.localRepository
```
   1.1.2. Если папка скрыта, нужно подняться на директорию выше и <br>
   - для Mac OS X На клавиатуре Mac нажмите комбинацию [cmd] + [Shift] + [.].<br>
   - для Windows выберите Вид > Параметры > Изменить параметры папок и поиска.
   На вкладке Вид в разделе Дополнительные параметры выберите Показывать скрытые файлы, папки и диски и нажмите ОК.<br>
   - для Linux на клавиатуре Mac нажмите комбинацию [Ctrl] + [H] или посмотрите включение для своего дистрибьютива.

 2. Установить локально или запустить в контейнере базу PostgresSQL с дефолтными db_name/user/password = nlmk-mes-warehouse
 3. Прописать логин и пароль для oracle БД. Попросить так же у коллег черз OTS.
 - пример docker-compose файла
 ```yaml
version: "3.8"
services:
    postgres:
      image: postgres:13.3-alpine
      container_name: nlmk-mes-warehouse_db
      environment:
        POSTGRES_DB: "nlmk-mes-warehouse"
        POSTGRES_USER: "nlmk-mes-warehouse"
        POSTGRES_PASSWORD: "nlmk-mes-warehouse"
        PGDATA: "/var/lib/postgresql/data"
      ports:
        - "5432:5432"
      volumes:
        - pg_data_volume:/var/lib/postgresql/data

volumes:
  pg_data_volume:
   ```
 3. Подлить все последние изменения в develop.
 4. Можно собрать проект выполняем Maven clean и compile.
 5. Запускаем проект Run/Debug 'WarehouseApplication'.
 6. Если не сгенерировались DTO из авро-схем, то переходим в папку target->generated-sources->avro и правой кнопкой -> Mark directory as
       -> Generated source root.

