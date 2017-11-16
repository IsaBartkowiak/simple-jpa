<nav class="navbar navbar-toggleable-md navbar-inverse bg-primary">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/INF2_JPA">Bibliothèque</a>
        </div>
        <div id="navbarNavDropdown" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="nav-item dropdown" class="${active eq  'book' ? 'active' : ''}">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Livres
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/INF2_JPA/">Tous les livres</a>
                        <a class="dropdown-item" href="/INF2_JPA/add">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown" class="${active eq  'author' ? 'active' : ''}">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Auteurs
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/INF2_JPA/authors">Tous les auteurs</a>
                        <a class="dropdown-item" href="/INF2_JPA/add-author">Ajouter</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br/><br/>

