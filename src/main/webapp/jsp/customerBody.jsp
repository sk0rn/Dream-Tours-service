<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/static/css/toggleCheckbox.css">

    <title>Профиль пользователя</title>
</head>
<body>
<div class="row">
    <div class="col-3">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
               aria-controls="v-pills-profile" aria-selected="true">Личная информация</a>
            <a class="nav-link" id="v-pills-wishlist-tab" data-toggle="pill" href="#v-pills-wishlist" role="tab"
               aria-controls="v-pills-wishlist" aria-selected="false">Список желаний</a>
            <a class="nav-link" id="v-pills-order-tab" data-toggle="pill" href="#v-pills-order" role="tab"
               aria-controls="v-pills-order" aria-selected="false">Заказы</a>
        </div>
    </div>

    <div class="col-8">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-profile" role="tabpanel"
                 aria-labelledby="v-pills-profile-tab">
                <form action="" method="">
                    <br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"
                                  id="inputGroup-sizing-default">ФИО:</span>
                        </div>
                        <input type="text" class="form-control" value="Иванов Петр Сидорович" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="submit">Изменить</button>
                        </div>
                    </div>
                    <br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"
                                  id="inputGroup-sizing-default">email:</span>
                        </div>
                        <input type="text" class="form-control" value="Piter.the.great@russia.com" aria-label="Default"
                               aria-describedby="inputGroup-sizing-default">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="submit">Изменить</button>
                        </div>
                    </div>
                    <br>
                    <h4>Количество бонусных очков: 42</h4>
                    <br>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span>Подписаться на рассылку </span>
                        </div>
                        <div class="input-group-append">
                            <label class="switch switch_type1" role="switch">
                                <input type="checkbox" class="switch__toggle" checked>
                                <span class="switch__label"></span>
                            </label>
                        </div>
                    </div>
                    <input type="button" class="btn btn-danger" value="Удалить аккаунт..." style="float: right;">
                </form>
            </div>

            <div class="tab-pane fade" id="v-pills-wishlist" role="tabpanel" aria-labelledby="v-pills-wishlist-tab">
                <form action="" method="">
                    <div class="form-group">
                        <label for="exampleFormControlSelectСall"></label>
                        <select multiple class="form-control" id="exampleFormControlSelectСall" name="callSelect">
                            <option>Список желаний</option>
                        </select>
                        <br>
                        <button type="submit" class="btn btn-primary">Редактировать</button>
                        <button type="submit" class="btn btn-primary">Удалить из списка</button>
                    </div>
                </form>
            </div>

            <div class="tab-pane fade" id="v-pills-order" role="tabpanel" aria-labelledby="v-pills-order-tab">
                <form action="" method="">
                    <label for="exampleFormControlSelectСall"></label>

                    <select multiple class="form-control" id="exampleFormControlSelectСall" name="callSelect">
                        <option>Список заказов</option>
                    </select>
                    <br>
                </form>
            </div>

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                    crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                    integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                    crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                    integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                    crossorigin="anonymous"></script>

            <script src="/static/js/dream_tours.js"></script>
</body>
</html>