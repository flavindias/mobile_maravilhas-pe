<div class="actions columns large-2 medium-3">
    <h3><?= __('Actions') ?></h3>
    <ul class="side-nav">
        <li><?= $this->Html->link(__('List Addresses'), ['action' => 'index']) ?></li>
        <li><?= $this->Html->link(__('List Wonders'), ['controller' => 'Wonders', 'action' => 'index']) ?> </li>
        <li><?= $this->Html->link(__('New Wonder'), ['controller' => 'Wonders', 'action' => 'add']) ?> </li>
    </ul>
</div>
<div class="addresses form large-10 medium-9 columns">
    <?= $this->Form->create($address); ?>
    <fieldset>
        <legend><?= __('Add Address') ?></legend>
        <?php
            echo $this->Form->input('city');
            echo $this->Form->input('street');
            echo $this->Form->input('neighborhood');
            echo $this->Form->input('complemento');
            echo $this->Form->input('latitude');
            echo $this->Form->input('longitude');
            echo $this->Form->input('sector');
            echo $this->Form->input('wonder_id', ['options' => $wonders]);
        ?>
    </fieldset>
    <?= $this->Form->button(__('Submit')) ?>
    <?= $this->Form->end() ?>
</div>
