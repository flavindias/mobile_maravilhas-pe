<div class="actions columns large-2 medium-3">
    <h3><?= __('Actions') ?></h3>
    <ul class="side-nav">
        <li><?= $this->Html->link(__('New Wonder'), ['action' => 'add']) ?></li>
        <li><?= $this->Html->link(__('List Addresses'), ['controller' => 'Addresses', 'action' => 'index']) ?> </li>
        <li><?= $this->Html->link(__('New Address'), ['controller' => 'Addresses', 'action' => 'add']) ?> </li>
    </ul>
</div>
<div class="wonders index large-10 medium-9 columns">
    <table cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th><?= $this->Paginator->sort('id') ?></th>
            <th><?= $this->Paginator->sort('name') ?></th>
            <th><?= $this->Paginator->sort('wonderscol') ?></th>
            <th class="actions"><?= __('Actions') ?></th>
        </tr>
    </thead>
    <tbody>
    <?php foreach ($wonders as $wonder): ?>
        <tr>
            <td><?= $this->Number->format($wonder->id) ?></td>
            <td><?= h($wonder->name) ?></td>
            <td><?= h($wonder->wonderscol) ?></td>
            <td class="actions">
                <?= $this->Html->link(__('View'), ['action' => 'view', $wonder->id]) ?>
                <?= $this->Html->link(__('Edit'), ['action' => 'edit', $wonder->id]) ?>
                <?= $this->Form->postLink(__('Delete'), ['action' => 'delete', $wonder->id], ['confirm' => __('Are you sure you want to delete # {0}?', $wonder->id)]) ?>
            </td>
        </tr>

    <?php endforeach; ?>
    </tbody>
    </table>
    
</div>
