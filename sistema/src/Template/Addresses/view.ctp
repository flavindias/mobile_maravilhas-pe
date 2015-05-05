<div class="actions columns large-2 medium-3">
    <h3><?= __('Actions') ?></h3>
    <ul class="side-nav">
        <li><?= $this->Html->link(__('Edit Address'), ['action' => 'edit', $address->id]) ?> </li>
        <li><?= $this->Form->postLink(__('Delete Address'), ['action' => 'delete', $address->id], ['confirm' => __('Are you sure you want to delete # {0}?', $address->id)]) ?> </li>
        <li><?= $this->Html->link(__('List Addresses'), ['action' => 'index']) ?> </li>
        <li><?= $this->Html->link(__('New Address'), ['action' => 'add']) ?> </li>
        <li><?= $this->Html->link(__('List Wonders'), ['controller' => 'Wonders', 'action' => 'index']) ?> </li>
        <li><?= $this->Html->link(__('New Wonder'), ['controller' => 'Wonders', 'action' => 'add']) ?> </li>
    </ul>
</div>
<div class="addresses view large-10 medium-9 columns">
    <h2><?= h($address->id) ?></h2>
    <div class="row">
        <div class="large-5 columns strings">
            <h6 class="subheader"><?= __('City') ?></h6>
            <p><?= h($address->city) ?></p>
            <h6 class="subheader"><?= __('Street') ?></h6>
            <p><?= h($address->street) ?></p>
            <h6 class="subheader"><?= __('Neighborhood') ?></h6>
            <p><?= h($address->neighborhood) ?></p>
            <h6 class="subheader"><?= __('Complemento') ?></h6>
            <p><?= h($address->complemento) ?></p>
            <h6 class="subheader"><?= __('Latitude') ?></h6>
            <p><?= h($address->latitude) ?></p>
            <h6 class="subheader"><?= __('Longitude') ?></h6>
            <p><?= h($address->longitude) ?></p>
            <h6 class="subheader"><?= __('Sector') ?></h6>
            <p><?= h($address->sector) ?></p>
            <h6 class="subheader"><?= __('Wonder') ?></h6>
            <p><?= $address->has('wonder') ? $this->Html->link($address->wonder->name, ['controller' => 'Wonders', 'action' => 'view', $address->wonder->id]) : '' ?></p>
        </div>
        <div class="large-2 columns numbers end">
            <h6 class="subheader"><?= __('Id') ?></h6>
            <p><?= $this->Number->format($address->id) ?></p>
        </div>
    </div>
</div>
