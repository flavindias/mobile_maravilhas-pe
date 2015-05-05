<div class="actions columns large-2 medium-3">
    <h3><?= __('Ações') ?></h3>
    <ul class="side-nav">
        <li><?= $this->Html->link(__('Usuários'), ['controller'=>'users','action' => 'index']) ?></li>
        <li><?= $this->Html->link(__('Novo Usuário'), ['controller'=>'users','action' => 'add']) ?></li>
        <li><?= $this->Html->link(__('Maravilhas'), ['controller'=>'wonders','action' => 'index']) ?></li>
        <li><?= $this->Html->link(__('Nova Maravilha'), ['controller'=>'wonders','action' => 'add']) ?></li>
    </ul>
</div>