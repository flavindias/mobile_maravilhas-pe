<div class="actions columns large-2 medium-3">
    <h3><?= __('Actions') ?></h3>
    <ul class="side-nav">
        <li><?= $this->Html->link(__('Edit Wonder'), ['action' => 'edit', $wonder->id]) ?> </li>
        <li><?= $this->Form->postLink(__('Delete Wonder'), ['action' => 'delete', $wonder->id], ['confirm' => __('Are you sure you want to delete # {0}?', $wonder->id)]) ?> </li>
        <li><?= $this->Html->link(__('List Wonders'), ['action' => 'index']) ?> </li>
        <li><?= $this->Html->link(__('New Wonder'), ['action' => 'add']) ?> </li>
        <li><?= $this->Html->link(__('List Addresses'), ['controller' => 'Addresses', 'action' => 'index']) ?> </li>
        <li><?= $this->Html->link(__('New Address'), ['controller' => 'Addresses', 'action' => 'add']) ?> </li>
    </ul>
</div>
<div class="wonders view large-10 medium-9 columns">
    <h2><?= h($wonder->name) ?></h2>
    <div class="row">
        <div class="large-5 columns strings">
            <h6 class="subheader"><?= __('Name') ?></h6>
            <p><?= h($wonder->name) ?></p>
            <h6 class="subheader"><?= __('Wonderscol') ?></h6>
            <p><?= h($wonder->wonderscol) ?></p>
        </div>
        <div class="large-2 columns numbers end">
            <h6 class="subheader"><?= __('Id') ?></h6>
            <p><?= $this->Number->format($wonder->id) ?></p>
        </div>
    </div>
    <div class="row texts">
        <div class="columns large-9">
            <h6 class="subheader"><?= __('Description') ?></h6>
            <?= $this->Text->autoParagraph(h($wonder->description)); ?>

        </div>
    </div>
</div>
<div class="related row">
    <div class="column large-12">
    <h4 class="subheader"><?= __('Related Addresses') ?></h4>
    <?php if (!empty($wonder->addresses)): ?>
    <table cellpadding="0" cellspacing="0">
        <tr>
            <th><?= __('City') ?></th>
            <th><?= __('Street') ?></th>
            <th><?= __('Neighborhood') ?></th>
            <th><?= __('Complemento') ?></th>
            <th><?= __('Latitude') ?></th>
            <th><?= __('Longitude') ?></th>
            <th><?= __('Sector') ?></th>
            <th><?= __('Wonder Id') ?></th>
            <th><?= __('Id') ?></th>
            <th class="actions"><?= __('Actions') ?></th>
        </tr>
        <?php foreach ($wonder->addresses as $addresses): ?>
        <tr>
            <td><?= h($addresses->city) ?></td>
            <td><?= h($addresses->street) ?></td>
            <td><?= h($addresses->neighborhood) ?></td>
            <td><?= h($addresses->complemento) ?></td>
            <td><?= h($addresses->latitude) ?></td>
            <td><?= h($addresses->longitude) ?></td>
            <td><?= h($addresses->sector) ?></td>
            <td><?= h($addresses->wonder_id) ?></td>
            <td><?= h($addresses->id) ?></td>

            <td class="actions">
                <?= $this->Html->link(__('View'), ['controller' => 'Addresses', 'action' => 'view', $addresses->id]) ?>

                <?= $this->Html->link(__('Edit'), ['controller' => 'Addresses', 'action' => 'edit', $addresses->id]) ?>

                <?= $this->Form->postLink(__('Delete'), ['controller' => 'Addresses', 'action' => 'delete', $addresses->id], ['confirm' => __('Are you sure you want to delete # {0}?', $addresses->id)]) ?>

            </td>
        </tr>

        <?php endforeach; ?>
    </table>
    <?php endif; ?>
    </div>
</div>
