import tensorflow as tf
import os, shutil
from tensorflow.python.keras.preprocessing.image import ImageDataGenerator
import matplotlib.pyplot as plt
from tensorflow.python.keras.callbacks import EarlyStopping, ModelCheckpoint

base_train_dir = r'C:\Users\fabio\Documents\DataSets\dogs_vs_cats_dataset\train'

train_data_dir = os.path.join(base_train_dir, 'train_data')
os.mkdir(train_data_dir)
validation_data_dir = os.path.join(base_train_dir, 'validation')
os.mkdir(validation_data_dir)
test_data_dir = os.path.join(base_train_dir, 'test_data')
os.mkdir(test_data_dir)

train_cats_dir = os.path.join(train_data_dir, 'train_cats')
os.mkdir(train_cats_dir)
train_dogs_dir = os.path.join(train_data_dir, 'train_dogs')
os.mkdir(train_dogs_dir)

validation_cats_dir = os.path.join(validation_data_dir, 'validation_cats')
os.mkdir(validation_cats_dir)
validation_dogs_dir = os.path.join(validation_data_dir, 'validation_dogs')
os.mkdir(validation_dogs_dir)


fnames = ['cat.{}.jpg'.format(i) for i in range(1000)]
for fname in fnames:
    src = os.path.join(base_train_dir, fname)
    dst = os.path.join(train_cats_dir, fname)
    shutil.copyfile(src, dst)

fnames = ['cat.{}.jpg'.format(i) for i in range(1000, 1500)]
for fname in fnames:
    src = os.path.join(base_train_dir, fname)
    dst = os.path.join(validation_cats_dir)
    shutil.copy(src, dst)

fnames = ['dog.{}.jpg'.format(i) for i in range(1000)]
for fname in fnames:
    src = os.path.join(base_train_dir, fname)
    dst = os.path.join(train_dogs_dir, fname)
    shutil.copyfile(src, dst)

fnames = ['dog.{}.jpg'.format(i) for i in range(1000, 1500)]
for fname in fnames:
    src = os.path.join(base_train_dir, fname)
    dst = os.path.join(validation_dogs_dir, fname)
    shutil.copyfile(src, dst)


train_datagen = ImageDataGenerator(rescale=1./255)
validation_datagen = ImageDataGenerator(rescale=1./255)

train_generator = train_datagen.flow_from_directory(
    train_data_dir,
    target_size=(150, 150),
    batch_size=20,
    class_mode='binary'
)


validation_generator = validation_datagen.flow_from_directory(
    validation_data_dir,
    target_size=(150, 150),
    batch_size=20,
    class_mode='binary'
)

callback_list = [EarlyStopping(monitor='acc',
                               patience=1
                               ),

                 ModelCheckpoint(filepath='model.h5',
                                 monitor='val_loss',
                                 save_best_only=True
                                 )
                 ]


model = tf.keras.models.Sequential([tf.keras.layers.Conv2D(32, (7, 7), activation='relu', input_shape=(150, 150, 3)),
                                    tf.keras.layers.MaxPooling2D(2, 2),
                                    tf.keras.layers.Conv2D(64, (5, 5), activation='relu', kernel_initializer='glorot_uniform'),
                                    tf.keras.layers.MaxPooling2D(2, 2),
                                    tf.keras.layers.Dropout(0.2),
                                    tf.keras.layers.Conv2D(128, (3, 3), activation='relu', kernel_initializer='glorot_uniform'),
                                    tf.keras.layers.MaxPooling2D(2, 2),
                                    tf.keras.layers.Conv2D(256, (3, 3), activation='relu', kernel_initializer='glorot_uniform'),
                                    tf.keras.layers.MaxPooling2D(3, 3),
                                    tf.keras.layers.Conv2D(256, (1, 1), activation='relu', kernel_initializer='glorot_uniform'),
                                    tf.keras.layers.Flatten(),
                                    tf.keras.layers.Dense(512, activation='relu'),
                                    tf.keras.layers.Dense(1, activation='sigmoid')])

model.compile(optimizer=tf.keras.optimizers.RMSprop(0.001),
              loss=tf.keras.losses.binary_crossentropy,
              metrics=['accuracy'])


hist = model.fit_generator(train_generator,
                        steps_per_epoch=100,
                        epochs=20,
                        validation_data=validation_generator,
                        validation_steps=50)

loss = hist.history['loss']
val_loss = hist.history['val_loss']
epochs = range(1, 1 + len(loss))

plt.plot(epochs, loss, 'bo', label='Training Loss')
plt.plot(epochs, val_loss, 'b', label='Validation Loss')
plt.xlabel('Epochs')
plt.ylabel('Loss')
plt.title('Training and Validation Loss')
plt.legend()

plt.show()
plt.clf()

acc = hist.history['acc']
val_acc = hist.history['val_acc']

plt.plot(epochs, acc, 'bo', label='Training Acc')
plt.plot(epochs, val_acc, 'b', label='Validation Acc')
plt.xlabel('Epochs')
plt.ylabel('Loss')
plt.title('Training and Validation Acc')
plt.legend()

plt.show()
plt.clf()



