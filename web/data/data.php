<?php

    $user = json_decode(file_get_contents('php://input'));

    if ( $user->mail == 'ivan@gmail.com' && $user->pass == '123' ) print 'true';


?>